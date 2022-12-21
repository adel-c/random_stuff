<script lang="ts">
	
	let a = 0;
	let b = 0;
	let total = 0;

	async function add() {
		const response = await fetch('/api/add', {
			method: 'POST',
			body: JSON.stringify({ a, b }),
			headers: {
				'content-type': 'application/json'
			}
		});

		total = await response.json();
	}
	async function randomValues() {
		a =await fetchRandomValue();
		b =await fetchRandomValue();
	}
	async function fetchRandomValue(): Promise<number> {
		const response = await fetch('/api/random-number?min=1&max=100', {
			method: 'GET'
		});

		return await response.json();
	}
</script>
<div>
<input type="number" bind:value={a} /> +
<input type="number" bind:value={b} /> =
{total}

<button on:click={add}>Calculate</button>

<button on:click={randomValues}>random data</button>
</div>
