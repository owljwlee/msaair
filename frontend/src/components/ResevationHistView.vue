<template>

    <v-data-table
        :headers="headers"
        :items="resevationHist"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'ResevationHistView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "customerId", value: "customerId" },
                { text: "scheduleId", value: "scheduleId" },
                { text: "mileage", value: "mileage" },
                { text: "eventType", value: "eventType" },
            ],
            resevationHist : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/resevationHists'))

            temp.data._embedded.resevationHists.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.resevationHist = temp.data._embedded.resevationHists;
        },
        methods: {
        }
    }
</script>

