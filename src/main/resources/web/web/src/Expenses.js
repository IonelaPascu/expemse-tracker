import React, {Component} from 'react';
import AppNav from './AppNav';
import DatePicker from 'react-datepicker';
import './App.css';
import "react-datepicker/dist/react-datepicker.css";
import {Table,Container, FormGroup, Form, Button} from 'reactstrap';
import {Link }from 'react-router-dom';
import Moment from 'react-moment';



class Expenses extends Component{

    emptyItem = {
        description:'',
        expenseDate:new Date(),
        id:108,
        categoryExpenses:{id :1, name:''}
    }

constructor(props) {
    super(props);

    this.state = {
           isLoading: false,
        categoryExpenses: [],
           Expenses: [],
           date: new Date(),
          item:this.emptyItem,



    }
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleTitleChange= this.handleTitleChange.bind(this);
    this.handleCategoryChange= this.handleCategoryChange.bind(this);
    this.handleChange=this.handleChange.bind(this);
    this.handleDateChange= this.handleDateChange.bind(this);
}

async handleSubmit(event){

        const item = {};
        item.categoryExpenses = this.state.item.categoryExpenses;
        item.description = this.state.item.title;
        item.expenseDate = this.state.item.expenseDate;

        await fetch('http://localhost:8085/api/expenses' , {
            method: 'POST',
            headers:{
                'Accept' : 'application/json',
                'Content-Type' : 'application/json'
            },
            body: JSON.stringify(item),
        });
        event.preventDefault();
       // this.props.history.push("/expenses");
}


    handleCategoryChange(event){

        const target= event.target;
        const name = target.name;
        const value= target.value;

        let item={...this.state.item};
        let catId = event.target.value;
        let catName = event.target.selectedOptions[0].label;
        item.categoryExpenses.id= catId;
        item.categoryExpenses.name = catName;
        item[name] = value;
        this.setState({item});

        console.log(this.state.categoryExpenses)

    }
    handleTitleChange(event){
        const target= event.target;
        const value= target.value;
        const name = target.name;
        let item={...this.state.item};
        item[name] = value;

        this.setState({item});
        console.log(item);
        console.log(this.state.item);
    }

    handleDateChange(date){
        let item={...this.state.item};
        item.expenseDate= date;
        this.setState({item});

    }
    handleChange(event){
        const target= event.target;
       this.setState({value:event.target.value})
    }
async remove(id){

        await fetch('http://localhost:8085/api/expenses/'+id, {
                method: 'DELETE',
                headers:{
                     'Accept': 'application/json',
                     'Content-Type' : 'application/json'
            }

            }).then(() => {
            let updatedExpenses = [...this.state.Expenses].filter(i => i.id !== id);
                this.setState({Expenses:updatedExpenses});

    });
}

    async componentDidMount() {
        const response = await fetch('http://localhost:8085/api/categories');
        const body = await response.json();  // vine inapoi ca un json object
        this.setState({categoryExpenses:body, isLoading:false});

        const responseExp = await fetch('http://localhost:8085/api/expenses');
        const bodyExp = await responseExp.json();  // vine inapoi ca un json object
        console.log(bodyExp);
        this.setState({Expenses:bodyExp, isLoading:false});
    }


    render() {
        const title =<h3>Add expense</h3>;
        const{categoryExpenses} = this.state;
        const {Expenses, isLoading} =this.state;



        if(isLoading)
            return (<div>Loading...</div>)

       let optionList =
           categoryExpenses.map(category =>
                <option value ={category.id} key ={category.id}>
                    {category.name}
                </option>)


        let rows =
            Expenses.map(expense =>
            <tr key={expense.id}>
                <td>{expense.description}</td>
                <td><Moment date={expense.expenseDate} format="YYYY/MM/DD"></Moment></td>
                <td>{expense.categoryExpenses.name}</td>
                <td><Button size="sm" color ="danger" onClick={() => this.remove(expense.id)}>Delete</Button> </td>

            </tr> )


        return(
            <div>
                <AppNav/>
                <Container>
                    {title}

               <Form onSubmit={this.handleSubmit}>
                   <FormGroup>
                       <span> <label htmlFor ="title">Title </label> </span>
                       <input type="title" name="title" id ="title" onChange= {this.handleTitleChange} autoComplete="name"/>
                   </FormGroup>

                   <FormGroup>
                       <span > <label htmlFor ="category">Category </label> </span>
                       <select onChange={ this.handleCategoryChange}>
                           {optionList}
                       </select>
                   </FormGroup>

                   <FormGroup>
                       <span> <label htmlFor ="expenseDate">Date </label> </span>
                       <DatePicker selected={this.state.item.expenseDate} onChange = { this.handleDateChange}/>
                   </FormGroup>


                   <div className="row">
                       <FormGroup className="col-md-4 mb-3">
                          <span> <label htmlFor="description">Description </label> </span>
                           <input type="text" name ="description" id = "description" onChange={this.handleChange}/>
                       </FormGroup>

                   </div>

                   <FormGroup>
                       <Button color ="primary" type ="submit">Save</Button>{' '}
                       <Button color ="secondary" tag ={Link} to="/">Cancel</Button>
                   </FormGroup>

               </Form>
                </Container>

                {''}
                <Container>
                   <h3>Expense list</h3>
                    <Table className="mt-4">
                      <thead>
                      <tr>
                          <th width="30%">Description</th>
                          <th >Date</th>
                          <th >Category</th>
                          <th width="10%">Action</th>
                      </tr>
                      </thead>
                        <tbody>
                        {rows}
                        </tbody>

                    </Table>
                </Container>

            </div>
            );
    }

}
export default Expenses;