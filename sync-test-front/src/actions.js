export const updateUser = (user) => ({
    type: 'UPDATE_USER',
    payload: {
      user
    },
    meta: {
      offline: {
        effect: { url: "http://localhost:8080/users/"+user.id+"/", method: 'POST', body: { user } },
        commit: { type: 'UPDATE_USER_COMMIT', meta: {user}},
        rollback: { type: 'UPDATE_USER_ROLLBACK', meta: {user}}
      }
    }
  });


export function getUser (userId){

  alert('Search for user id heere : ' + userId);
  
  return{
    type: 'GET_USER',
    payload: {
      userId
    },
    meta: {
      offline: {
        effect: { url: "http://localhost:8080/syncBack/user/"+userId+"/", method: 'GET'},
        commit: { type: 'GET_USER_COMMIT', meta: {userId}},
        rollback: { type: 'GET_USER_ROLLBACK', meta: {userId}}
      }
    }
  };

}
