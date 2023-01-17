import Layout from '../../components/layout';
import React, {useEffect, useState} from "react";
import {Todo} from "../../lib/Domain";
import {SubmitHandler, useForm} from "react-hook-form";
import useOpenNavBar, {fetchTodos, postTodo} from "../../lib/Todo";

function Machin({isOpen,handleToggle}:any){
    //const {isOpen,handleToggle} =useOpenNavBar()
    return(
<>
        <div>dans le truc</div>
    <button onClick={handleToggle}>{isOpen && "isOpen"} {!isOpen && "isClose"} </button>
</>
    )


}
export default function Todos() {

    const {isOpen,handleToggle} =useOpenNavBar()
    const {register, handleSubmit, watch, formState: {errors}} = useForm<Todo>();
    const [todos, setTodos] = useState([] as Todo[])
    const fetchData = async () => {
        const response = await fetchTodos()
        setTodos(response);
    }
    const onSubmit: SubmitHandler<Todo> = async data => {
        const response = await postTodo(data);
      //  setTodos([...todos, response])
        await fetchData()
    };

    useEffect(() => {


        // call the function
        fetchData()
            // make sure to catch any error
            .catch(console.error);
    }, []);

    return (
<>

<button onClick={handleToggle}>{isOpen && "isOpen"} {!isOpen && "isClose"} </button>
            <Machin isOpen={isOpen} handleToggle={handleToggle}></Machin>

</>
    );
}
