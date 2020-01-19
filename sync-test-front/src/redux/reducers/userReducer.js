import { fromJS } from 'immutable';

const initialState = {
    user:{},
    success: false,
    avatars:[
        {id:'1',uri:process.env.PUBLIC_URL+'/avatars/1.png'},
        {id:'2',uri:process.env.PUBLIC_URL+'/avatars/2.png'},
        {id:'3',uri:process.env.PUBLIC_URL+'/avatars/3.png'},
        {id:'4',uri:process.env.PUBLIC_URL+'/avatars/4.png'},
        {id:'5',uri:process.env.PUBLIC_URL+'/avatars/5.png'},
        {id:'6',uri:process.env.PUBLIC_URL+'/avatars/6.png'},
        {id:'7',uri:process.env.PUBLIC_URL+'/avatars/7.png'},

    ],
    errorMessage:"",

}

export default function (state = initialState, action={}) {
    switch (action.type) {		
        case `UPDATE_USER`:
            return {
                ...state,
                success: true,
            };
        case 'GET_USER':
                return {
                    ...state
    
            };
        case 'GET_USER_SUCCESS':

            return {
                ...state,
                user: action.payload.user
            };
        case 'UPDATE_USER_SUCCESS':

            return {
                ...state,
                user: action.payload.user
            };
        default:
            return {
                ...state,
            };
        }
    }
