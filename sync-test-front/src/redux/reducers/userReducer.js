const initialState = {
    userProfile: {},
    users: [],
    success: false
}

export default function (state = initialState, action={}) {
    switch (action.type) {		
        case `UPDATE_USER`:
            return {
                ...state,
                success: true,
            };
        default:
            return {
                ...state,
            };
        }
    }
