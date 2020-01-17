import React, { Component } from 'react';
import {updateUser, getUser} from './actions';
import {connect} from 'react-redux';

import './App.css';

class App extends Component{ 

  state = {
    idUser: '',
    name: '',
    email: '',
  }

  handleIdUserChange(e) {
    this.setState({idUser: e.target.value});
  }

  handleNameChange(e) {
    this.setState({name: e.target.value});
  }

  handleEmailChange(e) {
    this.setState({email: e.target.value});
  }

  searchUser() {
    alert('Search for user id : ' + this.state.idUser);
    this.props.getUser(this.state.idUser);

  }

  render(){
    return (
      <div className="App">
          <form onSubmit={()=>this.searchUser()}>
              <label> ID :
                <input type="text" value={this.state.idUser} onChange={(e)=> this.handleIdUserChange(e)} />
              </label>
              <input type="submit" value="search" />
          </form>

          <form onSubmit={()=>this.updateUser()}>
              <label> Name :
                <input type="text" value={this.state.name} onChange={(name)=> this.handleNameChange(name)} />
              </label>
              <label> Email :
                <input type="text" value={this.state.email} onChange={(email)=> this.handleEmailChange(email)} />
              </label>


              <input type="submit" value="save" />
          </form>


      </div>
    );
  }
}

const mapStateToProps = state => ({
  user: state.users.userProfile,
});

const mapDispatchToProps = dispatch => ({
  updateUser: user => dispatch(updateUser(user)),
  getUser: userId => dispatch(getUser(userId)),

});

export default connect(mapStateToProps, mapDispatchToProps)(App);
