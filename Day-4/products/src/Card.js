import {  Grid, Paper, Typography } from '@mui/material'



const Card = ({ item }) => {
    const d = new Date();
console.log(d.getFullYear());
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
                    <Typography style={{fontWeight:'bold'}}>{item.name} </Typography>
                    <Typography>{item.place}</Typography>
                    <Typography>{item.type}</Typography>
                    <Typography style={{backgroundColor:item.warranty<= d.getFullYear() ? '#ff3333':'green',color:'white' ,borderRadius:'25px',width:'50px'}}>{item.warranty}</Typography>
                    <br />
                </div>
            </Grid>
        </Paper>
    )
}

export default Card