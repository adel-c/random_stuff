import { useState } from "react";
import {Todo} from "./Domain";
export const fetchTodos: () => Promise<Todo[]> = async () => {
    // get the data from the api
    const response = await fetch(`/api/todo`);
    // convert the data to json
    const json = await response.json() as Todo[];

    // set state with the result
    return json
}

export const postTodo: (todo: Todo) => Promise<Todo> = async (todo) => {
    // get the data from the api
    const respose = await fetch(`/api/todo`, {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify(todo)
    })
    return respose.json()

}
let isOpen =false;
export default function useOpenNavBar(){
    const[,setIsOpen] = useState({});
    const handleToggle=()=>{
        isOpen=!isOpen
        setIsOpen({});
    }
    return {isOpen,handleToggle}
}
