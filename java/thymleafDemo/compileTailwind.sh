MY_UID="$(id -u)"
MY_GID="$(id -g)"

docker inspect tailwind_compiler > /dev/null 2>&1

  # Get the exit code of the command
  exit_code=$?

  if [ $exit_code -eq 0 ]; then
    echo "tailwind_compiler exists"
  else
    echo "tailwind_compiler does not exist"
    docker build -f ./src/main/frontend/Dockerfile . -t tailwind_compiler
  fi

#docker build -f ./src/main/frontend/Dockerfile . -t tailwind_compiler
docker run   -u $(id -u):$(id -g) -e RUN_WATCH=build -v .:/code tailwind_compiler
