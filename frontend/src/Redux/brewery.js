import * as ActionTypes from './actionTypes';

export const Brewery = (state = {
        id: null,
        name: '',
        city: '',
        state: '',
        brewery_logo_url: '',
        website_url: '',
        authorities: []
    }, action) => {
    switch (action.type) {
        case ActionTypes.ADD_BREWERY:
            return { ...state, 
                id: action.payload.id, 
                name: action.payload.name, 
                city: action.payload.city, 
                state: action.payload.state, 
                brewery_logo_url: action.payload.brewery_logo_url, 
                website_url: action.payload.website_url,
                authorities: action.payload.authorities }

        default:
            return state;
    }
}