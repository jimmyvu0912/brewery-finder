import * as ActionTypes from './actionTypes'

export const addToken = (token) => ({
    type: ActionTypes.ADD_TOKEN,
    payload: token
});

export const addUser = (user) => ({
    type: ActionTypes.ADD_USER,
    payload: user
})

export const deleteUser = () => ({
    type: ActionTypes.DELETE_USER
})

export const addReview = () => ({
    type: ActionTypes.ADD_REVIEW
})

export const addBeer = () => ({
    type: ActionTypes.ADD_BEER
})

export const deleteBeer = () => ({
    type: ActionTypes.DELETE_BEER
})

export const addBrewery = () => ({
    type: ActionTypes.ADD_BREWERY
})