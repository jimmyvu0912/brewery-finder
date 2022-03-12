import { createStore, combineReducers, applyMiddleware } from 'redux'
import thunk from 'redux-thunk'
import {Token} from './token'
import {User} from './user'
import { Brewery } from './brewery'
import { Beer } from './beer'
import { Review } from './review'

export const ConfigureStore = () => {
    const store = createStore(
        combineReducers({
            token: Token,
            user: User,
            brewery: Brewery,
            beer: Beer,
            review: Review
        }),
        applyMiddleware(thunk)
    );

    return store;
}