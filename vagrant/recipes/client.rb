include_recipe 'sensu::default'

sensu_client 'localhost' do
    name 'sensu-client-server'
    address '127.0.0.1'
    subscriptions ['all']
end

include_recipe 'sensu::client_service'
