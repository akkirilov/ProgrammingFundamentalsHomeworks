import React, { Component } from 'react';
import { Link } from 'react-router-dom';

import WithNotifications from '../../hocs/WithNotifications';
import WithLoading from '../../hocs/WithLoading';
import Comment from './Comment';
import requester from '../../infrastructure/requesterFetch';
import observer from '../../infrastructure/observer';

class PostDetailsBase extends Component {

    constructor(props) {
        super(props);
        this.state = {
            isAuthorized: '',
            date: '',
            data: {},
            content: '',
            comments: []
        }

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.deleteComment = this.deleteComment.bind(this);
    }

    calcTime(dateIsoFormat) {
        let diff = new Date - new Date(dateIsoFormat);
        diff = Math.floor(diff / 60000);
        if (diff < 1) return 'submitted less than a minute';
        if (diff < 60) return 'submitted ' + diff + ' minute' + pluralize(diff) + ' ago';
        diff = Math.floor(diff / 60);
        if (diff < 24) return 'submitted ' + diff + ' hour' + pluralize(diff) + ' ago';
        diff = Math.floor(diff / 24);
        if (diff < 30) return 'submitted ' + diff + ' day' + pluralize(diff) + ' ago';
        diff = Math.floor(diff / 30);
        if (diff < 12) return 'submitted ' + diff + ' month' + pluralize(diff) + ' ago';
        diff = Math.floor(diff / 12);
        return 'submitted ' + diff + ' year' + pluralize(diff) + ' ago';

        function pluralize(value) {
            if (value !== 1) return 's';
            else return '';
        }
    }

    componentDidMount() {
        console.log(this.props)
        let data = this.props.data.filter(x => x._id === this.props.match.params.id)[0];
        let isAuthorized = false;
            if (observer.isAdmin === true || sessionStorage.getItem('userId') === data._acl.creator ) {
                isAuthorized = true; 
            }
        this.setState({ data: data, date: data._kmd.ect,  isAuthorized});
        requester.get('appdata', 'comments', '')
        .then(comments => comments.json())
        .then(comments => {
            comments = comments.filter(x => x.postId === this.props.match.params.id);
            this.setState({ comments });
        })
    }

    handleSubmit(event) {
        event.preventDefault();
        if (this.state.content.length < 5) {
            this.props.error('Content of the comment must be more than 5 symbols!');
            return;
        }
        let data = {
            content: this.state.content,
            author: sessionStorage.getItem('username'),
            postId: this.props.match.params.id
        }
        requester.post('appdata', 'comments', '', data)
        .then(res => res.json())
        .then(res => {
            this.setState({comments: [...this.state.comments, res]});
        })
    }

    handleChange(event) {
        let content = event.target.value;
        this.setState({content});
    }

    deleteComment(event, id) {
        event.preventDefault();
        requester.remove('appdata', 'comments/' + id, '')
        .then(res => res.json())
        .then(res => {
            let comments = this.state.comments;
            comments = comments.filter(x => x._id !== id);
            this.setState({comments});
        })
    }

    render () {
        return (
            <section id="viewComments">
            <div className="post">
                <div className="col thumbnail">
                    <a href={this.state.data.url}>
                        <img src={this.state.data.imageUrl} alt="kartinka" />
                    </a>
                </div>
                <div className="post-content">
                    <div className="title">
                        <a href={this.state.data.url}>
                            {this.state.data.title}
                        </a>
                    </div>
                    <div className="details">
                        <p>{this.state.data.description}</p>
                        <div className="info">
                            {this.calcTime(this.state.date) +  ' by ' + this.state.data.author}
                        </div>
                        {this.state.isAuthorized ?
                            (<div className="controls">
                                <ul>
                                    <li className="action"><Link className="action editLink" to={'/posts/edit/' + this.state.data._id }>edit</Link></li>
                                    <li className="action"><Link className="action deleteLink" to={'/posts/delete/' + this.state.data._id }>delete</Link></li>
                                </ul>
                            </div>) : ''
                        }
                        

                    </div>
                </div>
                <div className="clear"></div>
            </div>
            <div className="post post-content">
                <form id="commentForm" method='POST'>
                    <label>Comment</label>
                    <textarea name="content" type="text" onChange={this.handleChange}></textarea>
                    <input type="submit" value="Add" id="btnPostComment" onClick={this.handleSubmit} />
                </form>
            </div>
            {this.state.comments.map(x => <Comment key={x._id} data={x} func={this.deleteComment} isAuthorized={this.state.isAuthorized}/>)}
        </section>
        )
    }
}
const PostDetailsWithNotifications = WithNotifications(PostDetailsBase);
const PostDetails = WithLoading(PostDetailsWithNotifications);

export default PostDetails;
