package com.vk.endpoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import com.vk.dto.ProdRelease;

@Component
@Endpoint(id = "releases")
public class FeatureReleaseEndpoint {

	List<ProdRelease> prodReleases = new ArrayList<>();

	@WriteOperation
	public void addNewReleaseInfo(@Selector String crq, @Selector String releaseDt, String features) {

		ProdRelease prodRelease = ProdRelease.builder().crq(crq).releaseDt(releaseDt)
				.features(Arrays.stream(features.split(",")).collect(Collectors.toList())).build();
		prodReleases.add(prodRelease);
	}

	@ReadOperation
	public List<ProdRelease> getAllReleases() {
		return prodReleases;
	}

	@ReadOperation
	public ProdRelease getProdReleaseByCRQ(@Selector String crq) {
		return prodReleases.stream().filter(prodRelease -> prodRelease.getCrq().equals(crq)).findAny().get();

	}

	@DeleteOperation
	public void deleteProdRelease(@Selector String crq) {
		prodReleases.remove(getProdReleaseByCRQ(crq));
	}
}
