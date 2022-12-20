<script>
    /** @type {import('./$types').PageData} */  
    export let data;
  </script>
  
  <h1>{data.slug}-{data.slup}</h1>
  <div>{@html data.content}</div>
<h1>la page slug</h1>
<p> {JSON.stringify(data)}</p>
