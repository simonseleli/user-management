import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom'

export default function ViewUser() {

    const {userId}=useParams();

    const [user,setUser]=useState({
        name:"",
        userName:"",
        email:""
    })

    useEffect(()=>{
        loadUsers();
    },[])

    const loadUsers=async()=>{
        const result= await axios.get(`http://localhost:8080/displaySingleUser/${userId}`);
        setUser(result.data)
    };
  return (
    <div className='container'>
    <div className='row'>
        <div className='col-md-6 offset-md border rounded p-4 mt-2'>
            <h3 className='text-center m-4'>User Details</h3>
            <div className='card'>
                <div className='card-header'>
                    Detaills of user id:{user.userId}
                    <ul className='list-group list-group-flush'>
                        <li className='list-group-item'>
                            <b>Name:</b>
                            {user.name}
                        </li>
                        <li className='list-group-item'>
                            <b>UserName:</b>
                            {user.userName}
                        </li>
                        <li className='list-group-item'>
                            <b>Email:</b>
                            {user.email}
                        </li>
                    </ul>
                </div>
            </div>
            <Link className='btn btn-primary my-2' to={"/"}>Back to Home</Link>
         </div>
      </div>
    </div>
  )
}
