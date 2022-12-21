import type { PageServerLoad, Actions } from './$types';
const users = {"a@c.com":"ua", "t@a.com":"ub"} as any;

export const load = (async ({ cookies }) => {
  const sessionId= cookies.get('sessionid') as string;
  const user = sessionId?.substring(7);
  return { user };
}) satisfies PageServerLoad;

const db = {
  getUser: (email: string):string => {
      return users[email] ??"RIEN";
  },
  createSession:(user:string)=>{
return "session"+user;
  }
}
export const actions: Actions = {
  /*
  default: async (event) => {
    // TODO log the user in
   console.log("azeaeaze")
  },
  */
  login: async ({ cookies, request }) => {
    const data = await request.formData();
    const email = data.get('email') as string;
    const password = data.get('password');
    const user =  db.getUser(email);
    cookies.set('sessionid',  db.createSession(user));

    return { success: user !=null };
  },
  register: async ({ cookies, request }) => {
    // TODO log the user in
    // https://kit.svelte.dev/docs/form-actions
    console.log("azeaeaze register", request)
  }
};