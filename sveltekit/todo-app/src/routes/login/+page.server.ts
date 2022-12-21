import type { Actions } from './$types';
 
export const actions: Actions = {
  /*
  default: async (event) => {
    // TODO log the user in
   console.log("azeaeaze")
  },
  */
  login: async (event) => {
    // TODO log the user in
   console.log("azeaeaze login",event)
  },
  register: async (event) => {
    // TODO log the user in
   // https://kit.svelte.dev/docs/form-actions
   console.log("azeaeaze register",event)
  }
};