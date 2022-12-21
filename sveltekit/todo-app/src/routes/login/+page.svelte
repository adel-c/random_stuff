<script lang="ts">
	import type { PageData, ActionData } from './$types';
  
	export let data: PageData;
  
	export let form: ActionData;
  </script>
  
  {#if form?.success}
	<!-- this message is ephemeral; it exists because the page was rendered in       response to a form submission. it will vanish if the user reloads --> 
	 <p>Successfully logged in! Welcome back, {data.user.name}</p>
  {/if}
<form method="POST" action="?/login">
	<label>
	  Email
	  <input name="email" type="email">
	</label>
	<label>
	  Password
	  <input name="password" type="password">
	</label>
	<button>Log in</button>
	<button formaction="?/register">Register</button>
  </form>