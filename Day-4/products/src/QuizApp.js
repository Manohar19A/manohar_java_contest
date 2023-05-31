import { Button } from '@mui/material';
import axios from 'axios';
import React, { useEffect, useState } from 'react'
import AddProduct from './AddQuiz';


const QuizApp = ({ type }) => {
    const [data, setData] = useState([])
    const [num, setNum] = useState(0)
    const [open, setOpen] = React.useState(false);
    const [status, setStatus] = useState(false)
    const [count, setCount] = useState(0)
    const [types, setType] = useState('')
    const [item, setItem] = useState(null)
    const handleClickOpen = () => {
        setOpen(true);
    };
    const handleClose = () => {
        setOpen(false);
        setType("")

    };
    useEffect(() => {
        axios.get("http://localhost:8080/quiz").then((res) => {
            console.log(res);
            setData(res.data);
        }).catch((err) => {
            console.log(err);
        })
    }, [status]);
    const toggle = () => {
        setStatus(!status)
    }
    const nextQuiz = () => {
        setNum(num + 1)
    }
    const prev = () => {
        setNum(num - 1)
    }
    const update = (id) => {

    }
    const handleSubmit = () => {

    }
    // console.log(count)
    return (
        <div>

            {type === 'admin' ? <AddProduct toggle={toggle} handleClickOpen={handleClickOpen} handleClose={handleClose} open={open} types={types} item={item} /> : (<></>)}
            <h4>Score : {count}</h4>
            {data.length === 0 ? (<h2>Loading...</h2>) : (
                <>
                    <h5>Question No: {num + 1}of {data.length}</h5>
                    <h3>{num+1}.{data[num].question}  <Button variant="contained" color='primary' size="small" onClick={() => {
                        setType('edit')
                        setOpen(true);
                        setItem(data[num])
                    }}>Edit</Button>  <Button variant="contained" color='error' size="small" onClick={() => {
                        axios.delete(`http://localhost:8080/quiz/${data[num].id}`).then((res) => {
                            console.log(res)
                            toggle();
                        }).catch((err) => {
                            console.log(err)
                        })
                    }}>Delete</Button></h3>
                    <input type='checkbox'  value={data[num].option1} onChange={(e) => (e.target.value === data[num].answer && e.target.checked) ? setCount(count + 1) : ""} />{data[num].option1}<br />
                    <input type='checkbox' value={data[num].option2} onChange={(e) => (e.target.value === data[num].answer && e.target.checked) ? setCount(count + 1) : ""} />{data[num].option2}<br />
                    <input type='checkbox' value={data[num].option3} onChange={(e) => (e.target.value === data[num].answer && e.target.checked) ? setCount(count + 1) : ""} />{data[num].option3}<br />
                    <input type='checkbox' value={data[num].option4} onChange={(e) => (e.target.value === data[num].answer && e.target.checked) ? setCount(count + 1) : ""} />{data[num].option4}<br /></>

            )}
            {data.length === num + 1 ? (<><Button onClick={prev}>Back</Button> <Button onClick={handleSubmit} size="small" variant="contained" color='primary'>Submit</Button></>) : (<>{num === 0 ? <></> : <Button onClick={prev} size="small" variant="contained" color='primary'>Back</Button>}  <Button onClick={nextQuiz} size="small" variant="contained" color='primary'>Next</Button> </>)}

        </div>
    )
}

export default QuizApp