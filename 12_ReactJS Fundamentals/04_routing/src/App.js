import React, { Component } from 'react';
import { Route, PropsRoute, Switch } from 'react-router-dom';

import Home from './components/home/Home';
import Header from './components/common/Header';
import Footer from './components/common/Footer';
import Navigation from './components/common/Navigation';
import Logout from './components/user/Logout';
import Catalog from './components/catalog/Catalog';
import MyPosts from './components/catalog/MyPosts';
import CreatePost from './components/catalog/CreatePost';
import PostDetails from './components/catalog/PostDetails';
import EditPost from './components/catalog/EditPost';
import DeletePost from './components/catalog/DeletePost';
import requester from './infrastructure/requesterFetch';

function catalogRequest () {
    return requester.get('appdata', 'posts', '');
}

function postRequest () {
    return requester.get('appdata', 'posts', '');
}

class App extends Component {
  render() {
    return (
      <div>
      <Header />
      <div className="content">
      <Navigation />
      <Switch>
        <Route path="/" exact component={Home}/>
        <Route path="/logout" exact component={Logout}/>
        <Route path="/catalog" exact component={() => <Catalog request={catalogRequest}/>} />
        <Route path="/create" exact component={CreatePost}/>
        <Route path="/myPosts" exact component={MyPosts}/>
        <Route path="/posts/:id" exact render={(props) => <PostDetails {...props} request={postRequest} />}  />
        <Route path="/posts/edit/:id" exact component={EditPost}/>
        <Route path="/posts/delete/:id" exact component={DeletePost}/>
      </Switch>
      </div>
      <Footer />
      </div>
    );
  }
}

export default App;
