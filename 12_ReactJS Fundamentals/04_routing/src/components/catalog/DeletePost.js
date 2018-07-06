import React, { Component } from 'react';
import { Redirect } from 'react-router-dom';

import '../../styles/submit.css';
import '../../styles/comments.css';

import WithNotifications from '../../hocs/WithNotifications'
import requester from '../../infrastructure/requesterFetch';

class EditPostBase extends Component {

    constructor(props) {
        super(props);
        this.state = {
            postData: {},
            view: null
        }

        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }

    componentDidMount() {
        let view = <Redirect to="/" />;
        if (sessionStorage.getItem('username')) {
            requester.get('appdata', 'posts/' + this.props.match.params.id, '')
            .then(postData => postData.json())
            .then(postData => {
                view = (
                    <section id="viewSubmit">
                        <div className="submitArea">
                            <h1>Submit Link</h1>
                            <p>Please, fill out the form. A thumbnail image is not required.</p>
                        </div>
                        <div className="submitArea formContainer">
                            <form id="submitForm" className="submitForm" method='POST'>
                                <label>Link URL:</label>
                                <input value={postData.url} name="url" type="text" disabled="disabled" />
                                <label>Link Title:</label>
                                <input value={postData.title} name="title" type="text" disabled="disabled" />
                                <label>Link Thumbnail Image (optional):</label>
                                <input value={postData.imageUrl} name="imageUrl" type="text" disabled="disabled" />
                                <label>Comment (optional):</label>
                                <textarea name="description" disabled="disabled" >{postData.description}</textarea>
                                <input id="btnSubmitPost" value="Submit" type="submit" onClick={this.handleSubmit}/>
                            </form>
                        </div>
                    </section>);
                this.setState({ postData, view });
            })
        } else {
            this.setState({ view });
        }
        
    }

    handleSubmit(event) {
        event.preventDefault();
        requester.remove('appdata', 'posts/' + this.props.match.params.id, '')
        .then(res => res.json())
        .then(res => {
            requester.get('appdata', 'comments', '')
                .then(comments => comments.json())
                .then(comments => {
                    comments.forEach(x => {
                        if (x.postId === this.state.postData._id) {
                            requester.remove('appdata', 'comments/' + x._id, '')
                        }
                    });
                    comments = comments.filter(x => x.postId === this.props.match.params.id);
                }).catch(err => this.props.error)
            this.props.info('Successfully removed!');
            this.setState({postData: {}, view: <Redirect to="/catalog"/>});
        }).catch(err => this.props.error)
    }

    handleChange(event) {
        let postData = this.state.postData;
        postData[event.target.name] = event.target.value;
        this.setState({postData});
    }

    render () {
        return this.state.view
    }
}

const EditPost = WithNotifications(EditPostBase);

export default EditPost;
