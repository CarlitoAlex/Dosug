
const events =
    [
        {name:'Playstation party', date: '18-12-2018 18:00', desc:'Bla vv BlaBlaBlaBlaBla'},
        {name:'Playstation party', date: '18-12-2018 18:00', desc:'Bla vv BlaBlaBlaBlaBla'},
        {name:'Playstation party', date: '18-12-2018 18:00', desc:'Bla vv BlaBlaBlaBlaBla'},
        {name:'Playstation party', date: '18-12-2018 18:00', desc:'Bla vv BlaBlaBlaBlaBla'}
    ];


new Vue({
    el: '#app',
    data:
         {
             events: events,
             eventOne: events[0]
         },
});







new Vue({
    el: '#app1',
    data() {
        return {
            info: null,
            loading: true,
            errored: false
        };
    },
    mounted() {
        axios
            .get('http://localhost:8083/getEvent')
            .then(response => {
                this.info = response.data;
            })
            .catch(error => {
                console.log(error);
                this.errored = true;
            })
            .finally(() => (this.loading = false));
    }
});