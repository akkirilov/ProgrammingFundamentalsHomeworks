import React, { Component } from 'react';
import { Link } from 'react-router-dom';

import '../../styles/post.css';
import '../../styles/comments.css';

import requester from '../../infrastructure/requesterFetch';
import Post from './Post';

class MyPosts extends Component {

    constructor(props) {
        super(props);
        this.state = {
            posts: []
        }
    }

    componentDidMount() {
        requester.get('appdata', 'posts', '')
        .then(res => res.json())
        .then(res => {
            console.log(res)
            if (res.error) {
                this.props.error(res.description);
            } else {
                res = res.filter(x => x._acl.creator === sessionStorage.getItem('userId'));
                this.setState({posts: res});
            }
        }).catch(err => console.log(err))
    }

    render () {
        return (
            <section id="viewCatalog">
                <div className="posts">
                    {this.state.posts.length > 0 ? this.state.posts.map(x => (<Post key={x._id} data={x} />)) : <div><p>You don't have posts!</p><p><Link to='/create'>Create new one?</Link></p></div>}
                </div>
            </section>
        )
    }
}

export default MyPosts;
