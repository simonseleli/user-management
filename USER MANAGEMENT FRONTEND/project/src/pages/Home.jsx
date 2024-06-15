import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate,Link, useParams } from 'react-router-dom';

export default function Home() {

  const {userId}=useParams();

   const [users, setUsers]=useState([]);

   useEffect(()=>{
    loadUsers();
   },[])

   const loadUsers=async()=>{
    const result=await axios.get("http://localhost:8080/displayAllUsers")
    setUsers(result.data)
   }

   const deleteUser=async(userId)=>{
      await axios.delete(`http://localhost:8080/deleteUser/${userId}`)
      loadUsers();
   }

  return (
    <div>

<div>
      <nav className="navbar navbar-expand-lg navibar-dark bg-primary">
  <div className="container-fluid">
    <a className="navbar-brand" href="#">USER MANAGEMENT SYSTEM</a>
    {/* <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span className="navbar-toggler-icon"></span>
    </button> */}
    <Link className='btn btn-outline-light' to="/adduser">Add User</Link>
    {/* <Link className='btn btn-outline-danger' to={"/hello"}>HELLO</Link> */}
  </div>
</nav>
    </div>

<div className='container'>
        <div className='py-4'></div>
        <table className="table table-primary text-center table-striped-columns border shadow">
  <thead>
    <tr>
      <th scope="col">SNO</th>
      <th scope="col">Name</th>
      <th scope="col">User Name</th>
      <th scope="col">Email</th>
      <th>Action</th>

    </tr>
  </thead>
  <tbody>
    {
      users.map((user,index)=>(
        <tr>
        <th scope="row" key={index}>{index+1}</th>
        <td>{user.name}</td>
        <td>{user.userName}</td>
        <td>{user.email}</td>
        <td>
          <Link className='btn btn-outline-primary mx-2' to={`/viewuser/${user.userId}`}>View</Link>
          <Link className='btn btn-outline-primary mx-2' to={`/edituser/${user.userId}`}>Edit</Link>
          <button className='btn btn-danger mx-2'onClick={()=>deleteUser(user.userId)}>Delete</button>
        </td>
      </tr>
      ))
    }
        
  </tbody>
</table>  
    </div>
    </div>
    
  )
}



