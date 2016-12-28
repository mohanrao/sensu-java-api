include_recipe 'sensu::default'
include_recipe 'sensu::rabbitmq'
include_recipe 'sensu::redis'
include_recipe 'sensu::server_service'
include_recipe 'sensu::api_service'

sensu_check 'check-disk' do
    command '/usr/bin/ruby1.9.3 /etc/sensu/plugins/check-disk.rb'
    handlers ['default']
    subscribers ['all']
    interval 120
end

sensu_check 'check-cpu' do
    command '/usr/bin/ruby1.9.3 /etc/sensu/plugins/check-cpu.rb -c 90 -w 80'
    handlers ['default']
    subscribers ['all']
    interval 120
    additional(:occurrences => 5)
end

sensu_check 'check-ram' do
    command '/usr/bin/ruby1.9.3 /etc/sensu/plugins/check-ram.rb -c 5 -w 10'
    handlers ['default']
    subscribers ['all']
    interval 120
    additional(:occurrences => 2)
end

sensu_check 'return-false' do
    command '/usr/bin/false'
    handlers ['default']
    subscribers ['all']
    interval 2
end

sensu_check 'return-another-false' do
    command '/usr/bin/false'
    handlers ['default']
    subscribers ['all']
    interval 2
end