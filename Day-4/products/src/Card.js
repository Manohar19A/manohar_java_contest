import { Grid, Paper, Typography } from '@mui/material'
import React, { useEffect, useState } from 'react'


const Card = ({ item }) => {
    return (
        <Paper elevation={3} style={{ height: "auto", width: "auto" }}>
            <Grid
                container
                direction="column"
                justifyContent="center"
                alignItems="center"
                style={{ padding: "5%", overflow: 'auto', maxHeight: '600px' }}
            >

                <div
                    style={{ display: "flex", flexDirection: "column", flexWrap: "wrap", alignItems: 'center', justifyContent: 'center', }}
                >
                    <Typography>{item.name} {item.place}</Typography>
                    <Typography>{item.type}</Typography>
                    <Typography>{item.warranty}</Typography>

                   
                    <br />

                </div>
            </Grid>
        </Paper>
    )
}

export default Card