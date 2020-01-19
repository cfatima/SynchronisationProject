import React, { Component } from 'react';
import {updateUser, getUser} from './actions';
import {connect} from 'react-redux';

import './App.css';

class App extends Component{ 

  state = {
    id: '',
    name: '',
    email: '',
    avatarId:'',
    update:false,
    selected: this.props.user.avatarId,
  }

  handleIdUserChange(e) {
    this.setState({id: e.target.value});
  }

  handleNameChange(e) {
    this.setState({name: e.target.value});
  }

  handleEmailChange(e) {
    this.setState({email: e.target.value});
  }

  searchUser() {
    this.props.getUser(this.state.id);
  }

  updateUser() {
    this.setState({update: true});
    this.setState({
      selected: this.props.user.avatarId,
      avatarId: this.props.user.avatarId,
      name: this.props.user.name,
      email: this.props.user.email,
      id: this.props.user.id
    });

  }
  saveUser() {
    
    var user={
      id:this.state.id,
      name:this.state.name,
      email:this.state.email,
      avatarId:this.state.avatarId
    }
    this.props.updateUser(user);

  }

  selectAvatar(e){
    var id=e.target.id;
    this.setState(
      {
        selected: id,
        avatarId: id
      });
  }


  render(){
    return (
      <div className="App">
          <form onSubmit={()=>this.searchUser()} id="search-form">
              <label> ID :
                <input type="text" value={this.state.id} onChange={(e)=> this.handleIdUserChange(e)} />
              </label>
              <input type="submit" value="search" />
          </form>
          {this.props.errorMessage!==""?
             <div>
                <p>{this.props.errorMessage}</p>
             </div>:
             <div></div>
          }

          {(this.props.user!==null && this.props.user.name!==undefined &&  this.state.update===false)?
          <form onSubmit={()=>this.updateUser()}  id="profile-form">
              <div className="Right">
                  <div id="Avatar-Profile-div">
                    <img className="Avatar-Profile-Img" src={process.env.PUBLIC_URL+'/avatars/'+this.props.user.avatarId+'.png'} alt=""/>
                  </div>

              </div>
              <div className="Left">
                <p> Name :
                  <span> {this.props.user.name}</span></p>
                <p> Email :
                  <span> {this.props.user.email}</span></p>
                <input id="update-profile-button" type="submit" value="update profile" />
              </div>

           
          </form>
          :<div></div>
        }
          {this.state.update===true ?
          <form onSubmit={()=>this.saveUser()}>
              <p><label> Name :
                <input type="text" value={this.state.name} onChange={(name)=> this.handleNameChange(name)} />
              </label></p>
              <p><label> Email :
                <input type="text" value={this.state.email} onChange={(email)=> this.handleEmailChange(email)} />
              </label></p>
              
              <div>
                <p><label> Choose Avatar :</label></p>


                {this.props.avatars.map(avatar=> {
                  return(
                    <div key={avatar.id} className="Avatar-Item" >
                      <img id={avatar.id} onClick={(e)=> this.selectAvatar(e)} className={(this.state.selected === avatar.id)?"selected":"not-selected"}  src={avatar.uri} alt="" height="40" width="40" margin="4 px"/>
                    </div>
                  );
                })}

              </div>
              <input type="submit" value="save"/>
          </form>
          :
          <div></div>
          }
      </div>
    );
  }
}

const mapStateToProps = state => ({
  user: state.users.user,
  avatars: state.users.avatars,
  errorMessage: state.users.errorMessage,

});

const mapDispatchToProps = dispatch => ({
  updateUser: user => dispatch(updateUser(user)),
  getUser: userId => dispatch(getUser(userId)),

});

export default connect(mapStateToProps, mapDispatchToProps)(App);
