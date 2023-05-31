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
const AddProduct = ({ toggle, handleClose, handleClickOpen, open, types, item }) => {
    console.log(item, types)
    // const [open, setOpen] = React.useState(false);
    const [form, setForm] = React.useState({});
    function setField(field, value) {
        setForm({
            ...form,
            [field]: value,
        });
    }
    // const handleClickOpen = () => {
    //     setOpen(true);
    // };
    // const handleClose = () => {
    //     setOpen(false);
    // };
    const postdata=(form)=>{
        console.log(form)
        axios.post("http://localhost:8080/quiz", form).then((data) => {
            console.log(data);
            console.log(form);
            toggle();
            // setField(form)
            handleClose()
        }).catch((error) => {
            alert("uplaod failed");
        });

    }
    const updateData =(form)=>{
        console.log(form)
        axios.put(`http://localhost:8080/quiz/${item.id}`,form).then((data) => {
            console.log(data);
            console.log(form);
            toggle();
            // setField(form)
            handleClose()
        }).catch((error) => {
            alert("uplaod failed");
        });

    }
    const handleSubmit = (e) => {
        e.preventDefault();
        if(types === 'edit'){
            updateData(form)
        }else{
            postdata(form)

        }
       
    }
    return (
        <div>
            <Button variant="contained" color='primary' style={{ marginLeft: '10px' }} onClick={handleClickOpen}>
                Add Question
            </Button>
            <Dialog open={open} onClose={handleClose}>
                <DialogTitle>{types === 'edit' ? 'Edit Quiz' : 'Add Quiz'}</DialogTitle>
                <DialogContent>
                    <Container maxWidth="sm">
                        <form onSubmit={handleSubmit}>
                            <TextField
                                label="Question"
                                variant="outlined"
                                fullWidth
                                defaultValue={types === 'edit' ? item.question : ""}
                                margin="normal"
                                onChange={(e) => setField("question", e.target.value)}
                            />
                            <TextField
                                label="Technology"
                                variant="outlined"
                                fullWidth
                                margin="normal"
                                defaultValue={types === 'edit' ? item.technology : ""}
                                onChange={(e) => setField("technology", e.target.value)}
                            />
                            <TextField
                                label="option1"
                                variant="outlined"
                                fullWidth
                                margin="normal"
                                defaultValue={types === 'edit' ? item.option1 : ""}
                                onChange={(e) => setField("option1", e.target.value)}
                            />
                            <TextField
                                label="option2"
                                variant="outlined"
                                fullWidth
                                margin="normal"
                                defaultValue={types === 'edit' ? item.option2 : ""}
                                onChange={(e) => setField("option2", e.target.value)}
                            />
                            <TextField
                                label="option3"
                                variant="outlined"
                                fullWidth
                                defaultValue={types === 'edit' ? item.option3 : ""}
                                margin="normal"
                                onChange={(e) => setField("option3", e.target.value)}
                            />
                            <TextField
                                label="option4"
                                variant="outlined"
                                fullWidth
                                margin="normal"
                                defaultValue={types === 'edit' ? item.option4 : ""}
                                onChange={(e) => setField("option4", e.target.value)}
                            />

                            <TextField
                                label="answer"
                                variant="outlined"
                                fullWidth
                                defaultValue={types === 'edit' ? item.answer : ""}
                                margin="normal"
                                onChange={(e) => setField("answer", e.target.value)}
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