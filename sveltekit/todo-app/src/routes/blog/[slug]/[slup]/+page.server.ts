import { error } from '@sveltejs/kit';
/** @type {import('./$types').PageServerLoad} */
export function load({ params }) {
    if(params.slup ==='boom'){
    throw error(404, 'ça a boom');
  }
    return {
        ...params,
        title: 'Hello world!',
        content: 'Welcome to our blog. Lorem ipsum dolor sit amet...'
      };
  }