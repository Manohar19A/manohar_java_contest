import { Grid, Paper, TextField, Typography } from '@mui/material'
import React, { useEffect, useState } from 'react'
import Card from './Card'
import axios from 'axios'
import AddProduct from './AddProduct'


const Products = () => {
    const [data, setData] = useState([])
    const [search, setSearch] = useState("")
    const keys = ["name", "place", "type", "warranty"]
    useEffect(() => {
        axios.get('http://localhost:8080/prod').then((res) => {
            console.log(res)
            setData(res.data)
        })
            .catch((err) => {
                console.log(err)
            })
    }, [])
    return (
        <Grid container direction='column' gap={2}>

            <Grid container spacing={3}>
                <br />
                <Grid container
                    spacing={3}
                    direction="row"
                    justifyContent="flex-end"
                    alignItems="center">
                    <TextField type='search' size='small' style={{ float: 'right' }} placeholder="Search..." onChange={e => {
                        setSearch(e.target.value)
                    }
                    }
                    />

                    <AddProduct />
                </Grid>
                {
                    data.length === 0 ? (<Typography>Loading...</Typography>) : (<>
                        {data.filter(i => keys.some(key => i[key].includes(search))).map((item, index) => {
                            return (
                                <Grid item xs={12} sm={6} md={4} lg={3}>
                                    <Card item={item} index={index} />
                                </Grid>
                            );
                        })}</>)
                }
            </Grid>
        </Grid>
    )
}

export default Products