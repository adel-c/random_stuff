<html>
<head>
    <link href="/styles.css" rel="stylesheet" type="text/css">
    <link href="/static/style.css" rel="stylesheet" type="text/css">
    <script defer src='/webjars/alpinejs/dist/cdn.min.js'></script>


<body>
<h1>Items:</h1>
<#list data.items as item>
    <h2>The item at index ${item?index} is ${item}</h2>
</#list>
<div x-data="dropdown">
    <button @click="toggle">Expand</button>

    <span x-show="open">Content...</span>
</div>


<script>
    document.addEventListener('alpine:init', () => {

        Alpine.data('dropdown', () => ({
            open: false,

            toggle() {
                this.open = !this.open
            }
        }))
    })
</script>
</body>

</html>
