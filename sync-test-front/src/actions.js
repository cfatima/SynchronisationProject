export function updateUser (user) {

  return{
    type: 'UPDATE_USER',
    payload: {
      user
    },
    meta: {
      offline: {
        effect: { url: "http://localhost:8080/syncBack/users/"+user.id+"/", method: 'POST', body: JSON.stringify(user) },
        commit: { type: 'UPDATE_USER_SUCCESS', meta: {user}}
      }
    }
  }
  }


export function getUser (userId){
    
  return{
    type: 'GET_USER',
    payload: {
      userId
    },
    meta: {
      offline: {
        effect: { url: "http://localhost:8080/syncBack/users/"+userId+"/", method: 'GET'},
        commit: { type: 'GET_USER_SUCCESS', meta: {userId}}
      }
    }
  };

}
