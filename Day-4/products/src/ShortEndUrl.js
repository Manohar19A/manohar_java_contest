import { Button, TextField } from '@mui/material'
import axios from 'axios'
import React, { useState } from 'react'

const ShortEndUrl = () => {
    const [field, setField] = useState("")
    const [data, setData] = useState("")
    const getUrl = () => {
        axios.post("http://localhost:8080/url", { originalUrl: field }).then((res) => {
            console.log(res)
            setData(res.data)
        }).catch((err) => {
            console.log(err)
        })
    }
    return (
        <div>
           <p>Enter Your Link Here to get ShortEndUrl</p> 
            <TextField
                style={{ width: '800px' }}
                label="Link"
                variant="outlined"
                margin="normal"
                onChange={(e) => setField(e.target.value)}
            />
            {data && <h4>{data}</h4>}
            <br />
            <Button onClick={getUrl} variant="contained" color="primary">
                Submit
            </Button></div>
    )
}

export default ShortEndUrl