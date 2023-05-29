
import './App.css';
import AddProduct from './AddProduct';
import Products from './Products';
import { AppBar, Box, Button, Toolbar, Typography } from '@mui/material';
import ShortEndUrl from './ShortEndUrl';

function App() {
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
    <br/>
    <br/>
    <br/>
    <ShortEndUrl/>
    {/* <Products/> */}
    </div>
  );
}

export default App;
