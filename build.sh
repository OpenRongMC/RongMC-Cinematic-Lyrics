#!/usr/bin/env bash
set -euo pipefail

module_dir="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" && pwd)"
port_dir="$(cd -- "$module_dir/../.." && pwd)"
jdk="${JAVA_HOME:-/usr/lib/jvm/java-25-openjdk}"
minecraft="${GRADLE_USER_HOME:-$HOME/.gradle}/caches/fabric-loom/26.3/minecraft-merged.jar"
classpath="$minecraft:$(<"$port_dir/.port/qa-classpath.txt")"
output="$module_dir/build"
classes="$(mktemp -d)"
trap 'find "$classes" -depth -delete' EXIT
mkdir -p "$output/libs"
mapfile -d '' sources < <(find "$module_dir/src/main/java" -name '*.java' -print0)
"$jdk/bin/javac" --release 25 -encoding UTF-8 -proc:none -cp "$classpath" -d "$classes" "${sources[@]}"
"$jdk/bin/jar" --create --file "$output/libs/rongmc-cinematic-lyrics-0.1.1+26.3.jar" \
    -C "$classes" . -C "$module_dir/src/main/resources" .
