cd /code/tailwind
npm i

if [ "$RUN_WATCH" == "watch" ]; then
  npx tailwindcss -i /code/src/main/resources/static/main.css -o /code/target/classes/static/main.css --watch
else
   npx tailwindcss -i /code/src/main/resources/static/main.css -o /code/target/classes/static/main.css
fi
