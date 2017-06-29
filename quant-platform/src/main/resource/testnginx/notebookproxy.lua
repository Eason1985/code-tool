local redis = require "resty.redis"
local red = redis.new()
red.connect(red, '127.0.0.1', '6379')
red:auth('123456')

local headers=ngx.req.get_headers()
local clientIp=headers["X-REAL-IP"] or headers["X_FORWARDED_FOR"] or ngx.var.remote_addr or "0.0.0.0"
local proxyId = ngx.null;
if clientIp ~= nil or clientIp ~= ngx.null then 
    proxyId = red:get('dynamicProxyAddr_'..clientIp)
end

local date=os.date("%Y%m%d%H%M%S");

if proxyId  == ngx.null or proxyId == '' then 
    ngx.redirect("http://192.168.14.129/lua", ngx.HTTP_MOVED_TEMPORARILY)
else 
    red:set('lastVisitDockerTime_'..clientIp , date ) 
	ngx.var.backend = proxyId 
end


