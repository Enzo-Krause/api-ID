package com.api.blog;

import java.util.List;
import java.util.UUID;
import com.api.blog.dto.request.PostRequest;
import com.api.blog.dto.response.PostResposta;

public interface PostService {
	List<PostResposta> findall();
	PostResposta findByld(UUID id);
	PostResposta createPoat(PostRequest dto);
}
