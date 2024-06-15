import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate,Link, useParams } from 'react-router-dom';

export default function EditUser() {

    let navigate=useNavigate();

    const {userId}=useParams();

    const [user, setUser]=useState({
        name:"",
        userName:"",
        email:""
    });

    const{name, userName,email}=user;

    const onInputChange=(e)=>{
        setUser({...user,[e.target.name]:e.target.value})
    };

    useEffect(()=>{
        loadUser();
    },[]);

    const onSubmit=async(e)=>{
        e.preventDefault();
        await axios.put(`http://localhost:8080/updateUser/${userId}`,user);
        navigate("/");
    }

    const loadUser=async()=>{
        const result=await axios.get(`http://localhost:8080/displaySingleUser/${userId}`);
        setUser(result.data)
    };

  return (
    <div className='container'>
        <div className='row'>
            <div className='col-md-6 offset-md border rounded p-4 mt-2'>
                <h3 className='text-center m-4'>Edit User</h3>

                <form onSubmit={(e)=>onSubmit(e)}>
                <div className='mb-3 text-center'>
                    <label htmlFor='Name' className='form-label'>Name</label>
                    <input type='text' className='form-control' placeholder='Enter your name' name='name' value={name} onChange={(e)=>onInputChange(e)}></input>
                </div>

                <div className='mb-3 text-center'>
                    <label htmlFor='userName' className='form-label'>userName</label>
                    <input type='text' className='form-control' placeholder='Enter your User name' name='userName' value={userName}  onChange={(e)=>onInputChange(e)}></input>
                </div>

                <div className='mb-3 text-center'>
                    <label htmlFor='email' className='form-label'>Email</label>
                    <input type='text' className='form-control' placeholder='Enter your Email' name='email' value={email}  onChange={(e)=>onInputChange(e)}></input>
                </div>

                <button type='submit' className='btn btn-outline-primary'>Submit</button>
                <Link className='btn btn-outline-danger mx-3' to={"/"}>Cancel</Link>
                </form>
            </div>
        </div>

    </div>
  )
}
