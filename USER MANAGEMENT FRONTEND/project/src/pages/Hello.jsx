import React from 'react';
import { useNavigate,Link, useParams } from 'react-router-dom';


export default function 
() {
  return (
    <div>
        <div className='container'>
        <div className='row'>
            <div className='col-md-6 offset-md border rounded p-4 mt-2'>
                <h3 className='text-center m-4'>Register User</h3>

                <form>
                <div className='mb-3 text-center'>
                    <label htmlFor='Name' className='form-label'>First Name</label>
                    <input type='text' className='form-control' placeholder='Enter your first name' name='firstName'></input>
                </div>

                <div className='mb-3 text-center'>
                    <label htmlFor='Name' className='form-label'>Middle Name</label>
                    <input type='text' className='form-control' placeholder='Enter your middle name' name='middleName'></input>
                </div>

                <div className='mb-3 text-center'>
                    <label htmlFor='Name' className='form-label'>Last Name</label>
                    <input type='text' className='form-control' placeholder='Enter your last name' name='lastName'></input>
                </div>

                <div className='mb-3 text-center'>
                    <label htmlFor='email' className='form-label'>Email</label>
                    <input type='text' className='form-control' placeholder='Enter your Email' name='emailId'></input>
                </div>

                <button type='submit' className='btn btn-outline-primary'>Submit</button>
                <Link className='btn btn-outline-danger mx-3' to={"/"}>Cancel</Link>
                </form>
            </div>
        </div>

    </div>
    </div>
  )
}
