cd /code/src/main/frontend
npm i

if [ "$RUN_WATCH" == "watch" ]; then
  npx tailwindcss -i main.css -o /code/target/classes/static/main.css --watch
else
   npx tailwindcss -i main.css -o /code/target/classes/static/main.css --watch
fi
