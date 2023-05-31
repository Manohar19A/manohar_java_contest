import {  Avatar, Grid, Paper, Typography } from '@mui/material'



const Card = ({ item }) => {
    console.log(item)
    const d = new Date();
console.log(d.getFullYear());
    return (
        <Paper elevation={3} style={{ height: "auto", width: "auto" }}>
            {item.map((item)=>(<Grid
                container
                direction="column"
                justifyContent="center"
                alignItems="center"
                style={{ padding: "5%", overflow: 'auto', maxHeight: '600px' }}
            >
                  <Avatar src={"https://m.media-amazon.com/images/M/MV5BYTRiNDQwYzAtMzVlZS00NTI5LWJjYjUtMzkwNTUzMWMxZTllXkEyXkFqcGdeQXVyNDIzMzcwNjc@._V1_.jpg" } style={{ width: "7rem", height:"7rem", backgroundColor: 'GrayText' }} ></Avatar>
                <div
                    style={{ display: "flex", flexDirection: "column", flexWrap: "wrap", alignItems: 'center', justifyContent: 'center', }}
                >
                    <Typography style={{fontWeight:'bold'}}>{item.title} </Typography>
                    <Typography>{item.titleType}</Typography>
                    <Typography>{item.season }:{item.episode}</Typography>
                    <Typography style={{backgroundColor:item.year<= d.getFullYear() ? '#ff3333':'green',color:'white' ,borderRadius:'25px',width:'50px'}}>{item.year}</Typography>
                    <br />
                </div>
            </Grid>))}
            
        </Paper>
    )
}

export default Card