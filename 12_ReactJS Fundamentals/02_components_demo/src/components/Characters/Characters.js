import React from 'react';

import Roster from './Roster';
import Details from './Details';
import fetcher from '../../fetcher';

const ROSTER_ENPOINT = '/roster';
const DETAILS_ENDPOINT = '/character/';

export default class Characters extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            roosters: null,
            details: null,
            currentId: null
        }
    }

    fetchDetails = (id) => {
        fetcher.get(DETAILS_ENDPOINT + id, (data) => {
            this.setState({
                details: <Details url={data.url} name={data.name} bio={data.bio}/>
            });
        });
    }

    componentDidMount  ()  {
        fetcher.get(ROSTER_ENPOINT, (data) => {
            this.setState({
                roosters: data.map(x => {
                    return (<Roster 
                    key={x.id} 
                    id={x.id} 
                    name={x.name} 
                    url={x.url} 
                    select={this.fetchDetails}/>);
                }),
                details: <Details url={data[0].url} name={data[0].name} bio={data[0].bio}/>,
                currentId: 0
            });
        });
    }

    render = () => (
            <div>
                 <section id="roster">
                {this.state.roosters}
                 </section>
                {this.state.details}
            </div>
        );
}