import * as React from 'react';
// import Button from '@mui/material/Button';
// import TextField from '@mui/material/TextField';
import { TextField, Button, Container } from '@mui/material';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import axios from 'axios';
const AddProduct = () => {
    const [open, setOpen] = React.useState(false);
    const [form, setForm] = React.useState({});
    function setField(field, value) {
        setForm({
            ...form,
            [field]: value,
        });
    }
    const handleClickOpen = () => {
        setOpen(true);
    };
    const handleClose = () => {
        setOpen(false);
    };
    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(form)
axios.post("http://localhost:8080/prod/addProduct",form).then((data) => {
    console.log(data);
    console.log(form);
    setField(form)
}).catch((error) => {
    alert("uplaod failed");
});
    }
    return (
        <div>
            <Button variant="outlined" style={{ marginLeft: '10px' }} onClick={handleClickOpen}>
                Add Product
            </Button>
            <Dialog open={open} onClose={handleClose}>
                <DialogTitle>Add Product</DialogTitle>
                <DialogContent>
                    <Container maxWidth="sm">
                        <form onSubmit={handleSubmit}>
                            <TextField
                                label="Name"
                                variant="outlined"
                                fullWidth
                                margin="normal"
                                onChange={(e) => setField("name", e.target.value)}
                            />
                            <TextField
                                label="Type"
                                variant="outlined"
                                fullWidth
                                margin="normal"
                                onChange={(e) => setField("type", e.target.value)}
                            />
                            <TextField
                                label="Place"
                                variant="outlined"
                                fullWidth
                                margin="normal"
                                onChange={(e) => setField("place", e.target.value)}
                            />
                           
                            <TextField
                                label="Year"
                                variant="outlined"
                                fullWidth
                                margin="normal"
                                onChange={(e) => setField("warranty", e.target.value)}
                            />
                            <Button type="submit" variant="contained" color="primary">
                                Submit
                            </Button>
                        </form>
                    </Container>



                </DialogContent>
                <DialogActions>
                    <Button onClick={handleClose}>Cancel</Button>
                </DialogActions>
            </Dialog>
        </div>
    );
}


export default AddProduct