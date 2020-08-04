import React, {Component} from 'react';
import AppNav from './AppNav';

import "./CategoryC.css";

class Category extends Component{

    state = {
        isLoading:true,
     Categories: []
    }
    // sync : you send a request then wait for response
    //async: you send a request and you do not have to wait
   async componentDidMount() {

        const response = await fetch('http://localhost:8085/api/categories');
        const body = await response.json();
        this.setState({Categories: body,isLoading:false});
    }

    render() {
        const {Categories, isLoading} = this.state;
        if(isLoading)
            return (<div>Loading...</div>);

//sa pun categoryId? la category.id


        return(<div className="box bkgimg">
            <AppNav  />
           <div  >
               <h2>Categories</h2></div>
                <span><h4>List of expenses: </h4> </span>
            {

                //lambda function
             Categories.map( category =>
                    <p>
                        <li id = {category.id}>
                            {category.name}
                        </li>
                    </p>
                )
            }
        </div>
        );
    }

}
export default Category;