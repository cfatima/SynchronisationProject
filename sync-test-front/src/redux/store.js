import { applyMiddleware, createStore, compose} from 'redux';
import { offline } from '@redux-offline/redux-offline';
import offlineConfig from '@redux-offline/redux-offline/lib/defaults';
import thunk from 'redux-thunk';
import logger from 'redux-logger';
import rootReducer from './reducers/rootReducer';

const store = createStore(
  rootReducer,
  {},
  compose(
    applyMiddleware(thunk,logger),
    offline(offlineConfig)
  )
);

export default store;