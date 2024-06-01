MY_UID="$(id -u)"
MY_GID="$(id -g)"
docker build -f ./src/main/frontend/Dockerfile . -t tailwind_compiler
docker run   -u $(id -u):$(id -g) -e RUN_WATCH=build -v .:/code -it tailwind_compiler
