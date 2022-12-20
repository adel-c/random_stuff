import { error } from '@sveltejs/kit';
export function load({ params }) {
   
    return {
        params,
        title: 'Hello world!',
        content: 'Welcome to our blog. Lorem ipsum dolor sit amet...'
      };
  }