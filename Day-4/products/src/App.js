
import './App.css';
import AddProduct from './AddProduct';
import Products from './Products';
import { AppBar, Box, Button, TextField, Toolbar, Typography } from '@mui/material';
import ShortEndUrl from './ShortEndUrl';
import QuizApp from './QuizApp';
import { useState } from 'react';

function App() {
  const [type, setType] = useState('')
  const [show,setShow]=useState(false)
  const shoe=()=>{
    setShow(true)
  }
  return (
    <div className="App">
      <Box sx={{ flexGrow: 1 }}>
        <AppBar position="static">
          <Toolbar>

            <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
              Products
            </Typography>
            {/* <Button color="inherit">Login</Button> */}
          </Toolbar>
        </AppBar>
      </Box>
      <br />
      <br />
      <br />
      
     
      {/* <ShortEndUrl/> */}
      {/* <Products/> */}
      {type !== ""&& show ?<>
      <h5>You are logged in as {type}</h5>
      <QuizApp type={type}/></>
      :(<> 
      <h6>Enter your Role</h6><TextField
        label="Role"
        variant="outlined"
        margin="normal"
        onChange={(e) => setType(e.target.value)}
      />
      <br/>
      <Button onClick={shoe}>Submit</Button></>)}
      
    </div>
  );
}

export default App;
